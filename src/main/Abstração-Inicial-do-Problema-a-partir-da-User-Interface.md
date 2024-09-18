Primeiramente foi criado um JSON básico, contendo todas as informações da User Interface do Figma:

```JSON
    {
  "name": "Gustavo",
  "accountNumber": "00000000-0",
  "accountAgency": "0000",
  "accountBalance": 1234.56,
  "accountLimit": 1000.00,
  "pixIcon": "",
  "pixDescrition": "PIX",
  "payIcon": "",
  "payDescription": "Pagar",
  "transferIcon": "",
  "transferDescription": "Transferir",
  "cardNumber": "xxxx xxxx xxxx 0000",
  "cardLimit": 1000.00,
  "newsIcon": "",
  "newsDescription": "O Santander tem soluções de crédito sob medida para você."
}
```
As informações contidas no JSON estão todas separadas.

Analisando os elementos do JSON é possível perceber que conta pode ser um elemento do corpo do JSON ao invés de deixar "accountNumber", "accountAgency", "accountBalance" e "accountLimit".

Para isso, vamos abstrair o problema, pensando em orientação a objetos, colocando então um elemento "account" no lugar:

```JSON
{
  "name": "Gustavo",
  "account": {
    "number": "00000000-0",
    "agency": "0000",
    "balance": 1234.56,
    "bimit": 1000.00,
             }
}
```
"account" agora é um elemento (ou chave) do JSON e o seu valor agora recebe outro JSON abstraindo os elementos do json princial.

Pix, pagamento e transferência têm ambos os mesmos atributos icon e description, logo é possível abistrar os elementos icon e description como uma lista de features:

```JSON
{
  "features": [
    {
        "icon": "",
        "descriprion": "Descrição das features, PIX, Pay e Transferência" 
    }
  ]
}
```

Assim como conta bancária (account), é possível abistrair os elementos:"cardNumber" e "cardLimit" da seguinte forma:

```JSON
{
  "card": {
    "number": "xxxx xxxx xxxx 0000",
    "limit": 1000.00
  }
}
```

E assim como uma feature, news também é uma lista de JSONs de acordo com a UI:
```JSON
{
  "news": [
    {
        "icon": "",
        "description": "Descrição da mensagem"
    }
  ]
}
```
**O resultado final é:**

```JSON
{
  "name": "Gustavo",
  "account": {
    "number": "00000000-0",
    "agency": "0000",
    "balance": 1234.56,
    "limit": 1000.00
  },
  "features": [
    {
      "icon": "",
      "description": "PIX"
    }
  ],
  "card": {
    "number": "xxxx xxxx xxxx 0000",
    "limit": 1000.00
  },
  "news": [
    {
      "icon": "",
      "description": "O Santander tem soluções de crédito sob medida para você"
    }
  ]
}
```