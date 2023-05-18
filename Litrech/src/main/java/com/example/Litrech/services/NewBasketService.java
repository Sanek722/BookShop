package com.example.Litrech.services;

import com.example.Litrech.Repository.BasketRepository;
import com.example.Litrech.Repository.ProductRepository;
import com.example.Litrech.models.Basket;
import com.example.Litrech.models.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class NewBasketService
{
    @Autowired
    private BasketRepository basketRepository;
    public void add(Basket basket) {
        basketRepository.saveAndFlush(basket);

    }

    public void deleteByid(int id) {
        basketRepository.deleteById(id);
    }
    public void deleteBasket()
    {
        basketRepository.deleteAll();
    }

    public List<Basket> getAll() {

        return basketRepository.findAll();
    }

    public int getFullPrice()
    {
        List<Basket> baskets = basketRepository.findAll();
        int chet = 0;

        for(Basket basket : baskets)
        {
            chet += basket.getPrice();
        }
        return chet;
    }
}
