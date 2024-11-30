package com.study.checkIn.utils;

import com.study.checkIn.dto.CheckInURLDTO;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class DivideURL {
    public static CheckInURLDTO divideCheckInURL(String checkInURL){
        CheckInURLDTO checkInURLDTO = new CheckInURLDTO();
        try {
            URI uri = new URI(checkInURL);
            checkInURLDTO.setHost(uri.getHost());
            checkInURLDTO.setProtocol(uri.getScheme());
            checkInURLDTO.setPath(uri.getPath());
            checkInURLDTO.setPort(String.valueOf(uri.getPort()));
            checkInURLDTO.setQuery(divideQuery(uri.getQuery()));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        System.out.println(checkInURLDTO);
        return checkInURLDTO;
    }

    private static Map<String, String> divideQuery(String uriQuery){
        Map<String, String> map = new HashMap<String, String>();
        String[] data = uriQuery.split("&&");
        for (String datum : data) {
            String[] data1 = datum.split("=");
            map.put(data1[0], data1[1]);
        }
        return map;
    }
}
