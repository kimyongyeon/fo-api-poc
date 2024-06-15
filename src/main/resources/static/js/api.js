const api = axios.create({
    baseURL: 'https://innisfree.com/kr/ko/bo', // API의 기본 URL
    timeout: 1000, // 요청 타임아웃 시간 (ms)
    headers: {'X-Custom-Header': 'foobar'} // 커스텀 헤더 설정
});

// 요청 전처리 (Request Interceptor)
api.interceptors.request.use(
    config => {
        // 요청 보내기 전에 수행할 로직

        // 인증 토큰 추가
        const token = localStorage.getItem('token');
        if (token) {
            config.headers.Authorization = `Bearer ${token}`;
        }

        // 요청 데이터 변환
        if (config.data) {
            config.data = JSON.stringify(config.data);
        }

        // 로깅 및 디버깅
        console.log('Request:', config);

        return config;
    },
    error => {
        // 요청 오류 처리
        console.error('Request Error:', error);
        return Promise.reject(error);
    }
);

// 응답 후처리 (Response Interceptor)
api.interceptors.response.use(
    response => {
        // 응답 데이터 가공
        const data = response.data;
        // 필요한 데이터 추출 및 변환 작업 수행

        // 캐싱
        if (response.config.method === 'get') {
            localStorage.setItem(`cache_${response.config.url}`, JSON.stringify(data));
        }

        // 로깅 및 모니터링
        console.log('Response:', response);

        return response;
    },
    error => {
        // 응답 오류 처리
        if (error.response) {
            // 서버로부터 받은 오류 응답
            if (error.response.status === 401) {
                // 인증 오류 시 로그인 페이지로 리다이렉트
                window.location.href = '/login';
            } else {
                console.error('Response Error:', error.response.data);
            }
        } else if (error.request) {
            // 서버로부터 응답을 받지 못한 경우
            console.error('No Response:', error.request);
        } else {
            // 오류를 발생시킨 요청을 설정하는 중에 문제 발생
            console.error('Error', error.message);
        }

        return Promise.reject(error);
    }
);

// GET 메서드
api.get = async function (endpoint, config = {}) {
    try {
        const response = await api.request({
            method: 'get',
            url: endpoint,
            ...config
        });
        return response.data;
    } catch (error) {
        // 에러 처리
        console.error('GET Error:', error);
        throw error;
    }
};

// POST 메서드
api.post = async function (endpoint, data, config = {}) {
    try {
        const response = await api.request({
            method: 'post',
            url: endpoint,
            data: data,
            ...config
        });
        return response.data;
    } catch (error) {
        // 에러 처리
        console.error('POST Error:', error);
        throw error;
    }
};

export default api;