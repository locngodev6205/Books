package com.example;

import com.example.lower_case.LowerCaseInputStream;
import com.example.starbuzz.Beverage;
import com.example.starbuzz.Espresso;
import com.example.starbuzz.HouseBlend;
import com.example.starbuzz.Mocha;
import com.example.starbuzz.Soy;
import com.example.starbuzz.Whip;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StarbuzzCoffee {
    public static void main(String[] args) throws IOException {

        // ── Decorator Pattern: Coffee ─────────────────────────────────────────
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        // ── Size-based pricing demo ───────────────────────────────────────────
        System.out.println("\n--- Size-based pricing ---");

        Beverage tall = new HouseBlend();
        tall.setSize(Beverage.Size.TALL);
        tall = new Soy(tall);
        tall = new Mocha(tall);
        System.out.println(tall.getDescription() + " (TALL)   $" + tall.cost());

        Beverage grande = new HouseBlend();
        grande.setSize(Beverage.Size.GRANDE);
        grande = new Soy(grande);
        grande = new Mocha(grande);
        System.out.println(grande.getDescription() + " (GRANDE) $" + grande.cost());

        Beverage venti = new HouseBlend();
        venti.setSize(Beverage.Size.VENTI);
        venti = new Soy(venti);
        venti = new Mocha(venti);
        System.out.println(venti.getDescription() + " (VENTI)  $" + venti.cost());

        // ── Decorator Pattern: InputStream ────────────────────────────────────
        String input = "I Know The Decorator Pattern Therefore I RULE!";

        // String → bytes → InputStream → bọc bằng LowerCaseInputStream
        InputStream in = new LowerCaseInputStream(
                             new ByteArrayInputStream(input.getBytes()));

        System.out.println("\nInput:  " + input);
        System.out.print("Output: ");

        int c;
        while ((c = in.read()) >= 0) {
            System.out.print((char) c);   // in ra chữ thường
        }
        System.out.println();

        in.close();
    }
}

