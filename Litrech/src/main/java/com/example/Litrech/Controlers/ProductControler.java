package com.example.Litrech.Controlers;

import com.example.Litrech.models.Basket;
import com.example.Litrech.models.Product;
import com.example.Litrech.services.NewBasketService;
import com.example.Litrech.services.NewProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductControler
{
    private final NewProductService newProductService;
    private final NewBasketService newBasketService;
    @GetMapping("/")
    public String index(Model model)
    {
        //List<Product> products = productService.getAllProducts();
        List<Product> products2 = newProductService.getAll();
        model.addAttribute("products", products2);
        model.addAttribute("id", 0);
        return "Books";
    }
    @GetMapping("/products")
    public String getProducts(Model model) {
        List<Product> products2 = newProductService.getAll();
        model.addAttribute("products", products2);
        model.addAttribute("id", 0);

        return "login.html";
    }
    @GetMapping("/basket")
    public String getBusket(Model model) {
        List<Basket> baskets = newBasketService.getAll();
        model.addAttribute("baskets", baskets);
        model.addAttribute("id", 0);
        model.addAttribute("full_price", newBasketService.getFullPrice());
        return "idex.html";
    }

    @PostMapping("/delete")
    public String deleteItem(@RequestParam(name = "id") int id)
    {
        newProductService.delete(id);
        return "redirect:/products";
    }
    @PostMapping("/update")
    public String updateProduct(@RequestParam(name = "id_add") int id,
                                @RequestParam(name = "price_update") int price
    )
    {
        Product product = new Product(id, newProductService.getAuthor(id),
                newProductService.getNamebook(id), price);

        newProductService.updateProduct(product);
        return "redirect:/products";
    }
    @PostMapping("/clear")
    public String clearBasket() {
        newBasketService.deleteBasket();
        return "redirect:/basket";
    }
    @PostMapping("/add")
    public String addProduct( @RequestParam(name = "author_add") String author,
                       @RequestParam(name = "namebook_add") String namebook,
                       @RequestParam(name = "id_add") int id,
                       @RequestParam(name = "price_add") int price)
    {
       newProductService.add(new Product(id,author,namebook,price));
        return "redirect:/products";
    }

    @PostMapping("/drop")
    public String addBasket(@RequestParam(name = "id") int id)
    {
        newBasketService.add(new Basket(id, newProductService.getAuthor(id),
                newProductService.getNamebook(id),
                newProductService.getPrice(id)));

        return "redirect:/";
    }

}
