package com.esliceu.demospring.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FirstController {
    @GetMapping("/first")
    public String first(HttpServletRequest req){
        req.setAttribute("nom", "Lluis");
        return "first";
    }
    @GetMapping("/second")
    public String second(Model model){
        model.addAttribute("temperature", "0");
        return "second";
    }
    @GetMapping("/primes")
    public String primes(Model model){
        List<Integer> primes = getPrimes();
        model.addAttribute("primes", primes);
        List<List<Integer>> taula = constructTable(primes);
        System.out.println(taula);
        model.addAttribute("taula", taula);
        return "primes";
    }

    private List<List<Integer>> constructTable(List<Integer> primes) {
        List<List<Integer>> result = new ArrayList<>();
        int pos = 0; //primes.size();
        while (pos < primes.size()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                if (pos+i >= primes.size()) break;
                int n = primes.get(pos + i);
                list.add(n);
            }
            while(list.size() < 3){
                list.add(0);
            }
            result.add(list);
            pos += 3;
        }
        return result;
    }

    private List<Integer> getPrimes() {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i < 100; i++) {
            if (isPrime(i)) {
                result.add(i);
            }
        }
        return result;
    }

    boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
