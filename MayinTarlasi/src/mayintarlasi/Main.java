/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mayintarlasi;

import java.util.Scanner;

/**
 *
 * @author iremu
 */
public class Main {
    public static void main(String[]args)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("---Mayın tarlası oyununa hoş geldiniz---");
        System.out.println("Kaç boyutlu olsun istersiniz ?:");
        System.out.print("Satır sayisi :");
        int satir=input.nextInt();
        System.out.print("Satır sayisi :");
        int sutun=input.nextInt();
        MayinTarlasi mayin=new MayinTarlasi(satir,sutun);
        mayin.run();
      
    }
    
}
