package com.example;

import java.rmi.Naming;
import java.util.Scanner;

import com.example.monitor.GumballMonitor;
import com.example.remote.GumballMachineRemote;

/**
 * CLIENT (Monitor): Kết nối từ xa đến GumballMachine qua RMI
 * và hiển thị trạng thái hiện tại. Có thể xem lại bất cứ lúc nào.
 * Chạy file này SAU KHI App (server) đã khởi động.
 */
public class GumballMonitorTestDrive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập địa chỉ máy cần giám sát (vd: localhost): ");
        String host = scanner.nextLine().trim();

        String url = "rmi://" + host + "/gumballmachine";
        GumballMachineRemote machine;

        try {
            machine = (GumballMachineRemote) Naming.lookup(url);
            System.out.println("Đã kết nối đến: " + url + "\n");
        } catch (Exception e) {
            System.err.println("Không thể kết nối đến: " + url);
            e.printStackTrace();
            scanner.close();
            return;
        }

        GumballMonitor monitor = new GumballMonitor(machine);

        // Vòng lặp xem trạng thái
        boolean running = true;
        while (running) {
            System.out.println("==============================");
            monitor.report();
            System.out.println("==============================");
            System.out.println("1. Xem lại trạng thái");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            String input = scanner.nextLine().trim();
            System.out.println();

            switch (input) {
                case "1":
                    // Lặp lại report ở đầu vòng
                    break;
                case "0":
                    running = false;
                    System.out.println("Monitor đã đóng.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }

        scanner.close();
    }
}
