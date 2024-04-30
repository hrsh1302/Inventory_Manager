package org.inventory;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class InventoryManagerController {
    @GetMapping("")
    public String home() {
        return "index";
    }

}
