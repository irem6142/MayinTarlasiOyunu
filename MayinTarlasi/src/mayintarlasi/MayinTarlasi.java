package mayintarlasi;

import java.util.Random;
import java.util.Scanner;

public class MayinTarlasi {

    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    int satir, sutun, size;
    int map[][];
    int board[][];
    boolean isGame = true;

    MayinTarlasi(int satir, int sutun) {
        this.satir = satir;
        this.sutun = sutun;
        this.map = new int[satir][sutun];
        this.board = new int[satir][sutun];
        this.size = satir * sutun;

    }

    public void run() {
        int row, col,succes=0;
        prepareGame();
        print(map);
        System.out.println("==Oyun Başladı==");
        while (isGame == true) {
            print(board);
            System.out.println("Satir değeri :");
            row = input.nextInt();
            System.out.println("Sütun değeri :");
            col = input.nextInt();
            if(row<0 || row>satir)
            {
                System.out.println("Geçersiz koordinat");
                continue;
            }
            if(col<0 || col>sutun)
            {
                System.out.println("==Geçersiz koordinat==");
                continue;
            }
            if (map[row][col] == -1) {
                System.out.println("==Kaybettiniz==");
                isGame = false;

            } else if (map[row][col] != -1) {
                succes++;
                if(succes==size-(size/4))
                {
                    System.out.println("==Başarılı.Kazandınız==");
                    break;
                }
                check(row, col);
            }

        }
    }

    public void prepareGame() {
        int sutunRand, satirRand, count = 0;//Sütün ve  satırlara rastgele mayın döşemek
        while (count != (size / 4)) {
            satirRand = rand.nextInt(satir);
            sutunRand = rand.nextInt(sutun);
            if (map[satirRand][sutunRand] != -1) {
                map[satirRand][sutunRand] = -1;
                count++;
            }
        }

    }

    public void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void check(int r, int c) {
        if(map[r][c]==0){
           if ( c>0 && map[r][c - 1] == -1) {
            board[r][c]++;
        }
        if ( c<sutun -1 && map[r][c + 1] == -1) {
            board[r][c]++;
        }
        if (r>0&& map[r - 1][c] == -1) {
            board[r][c]++;
        }
        
        if (r<satir -1 && map[r + 1][c] == -1) {
            board[r][c]++;
        } 
        /*ÇAPRAZLARINI DA KONTROL EDİYOR.
        if(r<satir-1 && c>0 && map[r+1][c-1]==-1)
        {
             board[r][c]++;
        }
         if(r>0 && c<sutun-1 && map[r-1][c+1]==-1)
        {
             board[r][c]++;
        }
          if(r<satir-1 && c<sutun-1 && map[r+1][c+1]==-1)
        {
             board[r][c]++;
        }
           if( r>0 && c>0 && map[r-1][c-1]==-1)
        {
             board[r][c]++;
        }
*/
       if(board[r][c]==0)
       {
           board[r][c]=-2;
       }
        }
        
    }
}
