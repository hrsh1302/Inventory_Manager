package org.inventory.controller;

import org.inventory.repositories.CategoryRepository;
import org.inventory.entities.Product;
import org.inventory.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    public ProductController(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }


    @GetMapping("/products")
    public String listProducts(Model model) {
        Iterable<Product> productList = productRepo.findAll();
        model.addAttribute("productList", productList);
        return "products";
    }


    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/products_saved")
    public String saveProduct(@ModelAttribute("product") Product product, RedirectAttributes ra, Model model) {
        Product existingProduct = productRepo.findProductByName(product.getName());
        if (existingProduct != null) {
            // Product with the same name already exists
            model.addAttribute("product", product);
            model.addAttribute("errorMessage", "A product with the name '" + product.getName() + "' already exists.");
            return "addProduct";
        }

        // Save the new product
        productRepo.save(product);
        ra.addFlashAttribute("message", "Product \"" + product.getName() + "\" was added!");
        return "redirect:/products";
    }


    @GetMapping("/lookProduct")
    public String showPage(Model model) {
        model.addAttribute("product", new Product());
        return "lookProduct";
    }

    @PostMapping("/lookProduct")
    public String searchByName(Product product, Model model, RedirectAttributes ra) {
        Product userProduct = productRepo.findProductByName(product.getName());

        if (userProduct != null) {
            model.addAttribute("product", userProduct);
            model.addAttribute("foundProductId", userProduct.getId());
            return "lookProduct";
        } else {
            ra.addFlashAttribute("error", "Product \" " + product.getName() + " \" was not found!");
            return "redirect:/lookProduct";
        }
    }

    @PostMapping("/lookProductById")
    public String searchById(@RequestParam Integer id, Model model, RedirectAttributes ra) {
        Product product = productRepo.findById(id).orElse(null);
        if (product != null) {
            model.addAttribute("product", product);
            return "lookProduct";
        } else {
            ra.addFlashAttribute("error", "Product with the ID {" + id + "} was not found!");
        }
        return "redirect:/lookProduct";
    }



    @GetMapping("/editProduct")
    public String editPage(Model model) {
        model.addAttribute("product", new Product());
        return "editProduct";
    }



    @PostMapping("/editProductById")
    public String searchByIdToEdit(@RequestParam Integer id, Model model, RedirectAttributes ra) {
        Product product = productRepo.findById(id).orElse(null);
        if (product != null) {
            model.addAttribute("product", product);
            ra.addAttribute("id", id);
            return "editProduct";
        } else {
            ra.addFlashAttribute("error", "Product was not found");
            return "redirect:/editProduct";
        }
    }


    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute Product updatedProduct, RedirectAttributes ra) {
        Product existingProduct = productRepo.findById(updatedProduct.getId()).orElse(null);

        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            existingProduct.setMinQuantity(updatedProduct.getMinQuantity());
            existingProduct.setDescription(updatedProduct.getDescription());

            productRepo.save(existingProduct);


            ra.addFlashAttribute("message", "Product \"" + updatedProduct.getName() + "\" updated successfully!");
            return "redirect:/products";
        } else {
            ra.addFlashAttribute("error", "Product \"" + updatedProduct.getName() + "\" was not found!");
        }
        return "redirect:/editProduct";
    }





    @GetMapping("/removeProduct")
    public String removePage(Model model) {
        model.addAttribute("product", new Product());
        return "removeProduct";
    }

    @PostMapping("/removeProduct")
    public String removeProduct(@RequestParam("name") String productName, RedirectAttributes ra) {
        Product userProduct = productRepo.findProductByName(productName);

        if (userProduct != null) {
            productRepo.delete(userProduct);
            ra.addFlashAttribute("message", "Product \"" + userProduct.getName() + "\" was removed!");
            return "redirect:/products";

        } else {
            ra.addFlashAttribute("error", "Product was not found");
        }
        return "redirect:/removeProduct";
    }

    @PostMapping("/removeProductById")
    public String removeProductById(@RequestParam("id") Integer productId, RedirectAttributes ra) {
        Optional<Product> productOptional = productRepo.findById(productId);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            productRepo.delete(product);
            ra.addFlashAttribute("message", "Product \"" + product.getName() + "\" was removed!");
            return "redirect:/products";
        } else {
            ra.addFlashAttribute("error", "Product was not found");
            return "redirect:/removeProduct";
        }
    }

}
