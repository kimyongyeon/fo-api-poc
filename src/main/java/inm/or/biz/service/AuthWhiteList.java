package inm.or.biz.service;

import feign.FeignException;
import inm.or.biz.api.OrderApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthWhiteList {
    private static OrderApi orderApi;
    private static HashSet<String> urlSet = new HashSet<>();

    public static void fetchURLsFromServer(String serverUrl) {

        try {
            List<String> urlList = List.of("/api1", "api2"); // orderApi.getURLList(serverUrl);
            urlList.stream().map(String::trim).forEach(urlSet::add);
        } catch (FeignException e) {
            System.out.println("Error while fetching URL list from server: " + e.getMessage());
        }
    }

    // Method to check if a URL exists in the set
    public static boolean isURLPresent(String url) {
        return urlSet.contains(url);
    }

    public static void main(String[] args) {
        fetchURLsFromServer("getWhiteList");
        System.out.println(isURLPresent("/api1"));
    }
}
