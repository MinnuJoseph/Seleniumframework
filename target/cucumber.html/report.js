$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SubmitOrder.feature");
formatter.feature({
  "line": 3,
  "name": "Submit the order",
  "description": "I want to use this template for my feature file",
  "id": "submit-the-order",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@tag"
    }
  ]
});
formatter.scenarioOutline({
  "line": 9,
  "name": "Submit the order in the Ecommerce website",
  "description": "",
  "id": "submit-the-order;submit-the-order-in-the-ecommerce-website",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 8,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "Logged in with \u003cusername\u003e and \u003cpassword\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "Adding the \u003cproductname\u003e to cart",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Checkout \u003cproductname\u003e and submit the order",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "verify confirmation message displayed",
  "keyword": "Then "
});
formatter.examples({
  "line": 15,
  "name": "",
  "description": "",
  "id": "submit-the-order;submit-the-order-in-the-ecommerce-website;",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "productname"
      ],
      "line": 16,
      "id": "submit-the-order;submit-the-order-in-the-ecommerce-website;;1"
    },
    {
      "cells": [
        "anshika@gmail.com",
        "Iamking@000",
        "ZARA COAT 3"
      ],
      "line": 17,
      "id": "submit-the-order;submit-the-order-in-the-ecommerce-website;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "Landed on Ecommercewebsite",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdefinition.landed_on_ecommercewebsite()"
});
formatter.result({
  "duration": 8141727300,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Submit the order in the Ecommerce website",
  "description": "",
  "id": "submit-the-order;submit-the-order-in-the-ecommerce-website;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@tag"
    },
    {
      "line": 8,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "Logged in with anshika@gmail.com and Iamking@000",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "Adding the ZARA COAT 3 to cart",
  "matchedColumns": [
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Checkout ZARA COAT 3 and submit the order",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "verify confirmation message displayed",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "anshika@gmail.com",
      "offset": 15
    },
    {
      "val": "Iamking@000",
      "offset": 37
    }
  ],
  "location": "Stepdefinition.logged_in_with_and(String,String)"
});
formatter.result({
  "duration": 229296200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ZARA COAT 3",
      "offset": 11
    }
  ],
  "location": "Stepdefinition.adding_the_to_cart(String)"
});
formatter.result({
  "duration": 9280159500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ZARA COAT 3",
      "offset": 9
    }
  ],
  "location": "Stepdefinition.checkout_and_submit_the_order(String)"
});
formatter.result({
  "duration": 1020597200,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.verify_confirmation_message_displayed()"
});
formatter.result({
  "duration": 16528421800,
  "status": "passed"
});
});