package com.example.consumingrest.resources;

import com.example.consumingrest.domain.Quote;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/randomquote")
@CrossOrigin(origins = "http://localhost:4200")
public class QuoteResource {

  private RestTemplate restTemplate;

  public QuoteResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GetMapping
  public ResponseEntity<Quote> getRandomQuote() {
    Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    return ResponseEntity.ok().body(quote);
  }

}
