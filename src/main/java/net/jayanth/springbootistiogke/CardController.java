package net.jayanth.springbootistiogke;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping(path = "/cards")
public class CardController {

  @Autowired
  private CardRepository cardRepository;

  @PostMapping()
  public @ResponseBody
  Mono<Card> addCard(@RequestBody Card card) {
    return cardRepository.save(card);
  }

  @GetMapping()
  public @ResponseBody
  Flux<Card> getAllCards() {
    Flux<Card> result = cardRepository.findAll();
    return result;
  }
}




