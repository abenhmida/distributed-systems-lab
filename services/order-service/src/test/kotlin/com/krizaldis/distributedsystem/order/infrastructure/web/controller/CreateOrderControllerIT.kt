package com.krizaldis.distributedsystem.order.infrastructure.web.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CreateOrderControllerIT {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `should create order`() {

        mockMvc.perform(
            post("/api/v1/orders")
                .contentType(APPLICATION_JSON)
                .content(
                    """
                {
                  "customerId":"customer-1",
                  "items":[
                    {
                      "productId":"product-1",
                      "quantity":2,
                      "price":15.50
                    }
                  ]
                }
                """
                )
        )
            .andExpect(status().isCreated)
    }
}