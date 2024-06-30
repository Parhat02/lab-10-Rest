package com.cydeo.client;

import com.cydeo.dto.weather.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://api.weatherstack.com", name = "WEATHER-CLIENT")
public interface WeatherClient {

    //http://api.weatherstack.com
    // /current
    // ?access_key=87e785a9468054d73eaf989af1e4a99a
    // &query=Paris

    @GetMapping("/current")
    WeatherResponse getCurrentWeather(@RequestParam("access_key") String accessKey, @RequestParam("query") String city);
}
