package com.domain.deal.assesment;


import com.domain.deal.assesment.dtos.DealRequest;
import com.domain.deal.assesment.dtos.DealResponse;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/deals")
public class DealAssessmentController {

    @GetMapping("/health")
    public  String health() {
        return "Deal Assessment Service is up and running!";
    }

    @PostMapping("/assess")
    @Operation(
            summary = "Assess deals",
            description = "Evaluates a list of deals and returns the assessment results.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "List of deals to assess",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Sample Request",
                                    value = "[{\"articleId\":\"12345\",\"price\":100.0,\"rrp\":150.0,\"quantity\":10,\"category\":\"electronics\"}]"
                            ),
                            schema = @Schema(implementation = DealRequest.class)
                    )
            )
    )
    public ResponseEntity<List<DealResponse>> assessDeals(@RequestBody List<DealRequest> deals) {
        List<DealResponse> results = new ArrayList<>();

        for (DealRequest deal : deals) {

            String status = deal.getPrice() < deal.getRrp() ? "Approved" : "Rejected";
            results.add(new DealResponse(deal.getArticleId(), status));
        }        return ResponseEntity.ok(results);
    }
}

