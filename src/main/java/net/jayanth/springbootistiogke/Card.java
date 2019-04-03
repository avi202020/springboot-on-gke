package net.jayanth.springbootistiogke;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

  private String cardId;
  private String cardNumber;
  private String issuingBank;
  private String cardOwner;
}
