package com.example;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

import com.example.state.GumballMachine;

/**
 * SERVER: Khởi động GumballMachine, đăng ký RMI, sau đó cho phép
 * người dùng thao tác máy bán kẹo qua menu tương tác.
 */
public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên/địa chỉ máy (vd: localhost): ");
        String location = scanner.nextLine().trim();

        System.out.print("Nhập số lượng kẹo ban đầu: ");
        int count = Integer.parseInt(scanner.nextLine().trim());

        GumballMachine gumballMachine;
        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry đã khởi động trên port 1099.");

            gumballMachine = new GumballMachine(location, count);
            Naming.rebind("//" + location + "/gumballmachine", gumballMachine);
            System.out.println("GumballMachine đã đăng ký tại: //" + location + "/gumballmachine\n");
        } catch (Exception e) {
            System.err.println("Lỗi khởi động server: " + e.getMessage());
            e.printStackTrace();
            scanner.close();
            return;
        }

        // Menu tương tác
        boolean running = true;
        while (running) {
            System.out.println("==============================");
            System.out.println(gumballMachine);
            System.out.println("------------------------------");
            System.out.println("1. Bỏ xu (Insert Quarter)");
            System.out.println("2. Rút xu (Eject Quarter)");
            System.out.println("3. Quay tay quay (Turn Crank)");
            System.out.println("4. Nạp thêm kẹo (Refill)");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            String input = scanner.nextLine().trim();
            System.out.println();

            switch (input) {
                case "1":
                    gumballMachine.insertQuarter();
                    break;
                case "2":
                    gumballMachine.ejectQuarter();
                    break;
                case "3":
                    gumballMachine.turnCrank();
                    break;
                case "4":
                    System.out.print("Nhập số kẹo nạp thêm: ");
                    try {
                        int refillCount = Integer.parseInt(scanner.nextLine().trim());
                        gumballMachine.refill(refillCount);
                    } catch (NumberFormatException e) {
                        System.out.println("Số không hợp lệ.");
                    }
                    break;
                case "0":
                    running = false;
                    System.out.println("Server đã dừng.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }

        scanner.close();
        System.exit(0);
    }
}
