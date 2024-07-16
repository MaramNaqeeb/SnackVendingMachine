package com.example.demo.VM;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		VM vm = new VM();

		vm.run();

	}

}
