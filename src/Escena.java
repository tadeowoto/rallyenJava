/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tDev
 */

import java.util.Scanner;

public class Escena {
    Auto auto;
    Pared pared;

    public Escena(Auto auto) {
        this.auto = auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public void setPared(Pared pared) {
        this.pared = pared;
    }
    
    //version a mejorar (auto.X>=pared.x && auto.x <= pared.x+5) && (auto.Y >= pared.Y && auto.Y <= pared.Y+5)
    public boolean choco(){
        for (int i = 1; i<5;i++){
            if (auto.getPosX() == pared.getPosX()+i && auto.getPosY() == pared.getPosY()){
                System.out.println("aca choco");
                auto.setChocado(true);
                break;
            }
        }
        for (int i = 1; i<5;i++){
            if (auto.getPosX() == pared.getPosX() && auto.getPosY() == pared.getPosY()+i){
                auto.setChocado(true);
                break;
            }
        }
        for (int i = 1; i<5;i++){
            if (auto.getPosX() == pared.getPosX()+i && auto.getPosY() == pared.getPosY()+5){
                auto.setChocado(true);
                break;
            }
        }
        for (int i = 1; i<5;i++){
            if (auto.getPosX() == pared.getPosX()+5 && auto.getPosY() == pared.getPosY()+i){
                auto.setChocado(true);
                break;
            }
        }
        System.out.println("no choco");
        return auto.isChocado();
    }
    public void jugar() {
        Scanner leer = new Scanner(System.in);
        //provisorio
        setPared(new Pared(3, 3));
        String opc ="";
        System.out.println("Que accion desea realizar");
        System.out.println("w) Mover arriba");
        System.out.println("s) Mover abajo");
        System.out.println("a) Mover izquierda");
        System.out.println("d) Mover derecha");
        System.out.println("n) Nuevo Auto");
        System.out.println("e) Para salir");
        do {
            opc = leer.next();
            switch (opc.toLowerCase()) {
                case "w":
                    auto.moverArriba();
                    break;
                case "s":
                    auto.moverAbajo();
                    break;
                case "a":
                    auto.moverIzquierda();
                    break;
                case "d":
                    auto.moverDerecha();
                    break;
                case "n":
                    System.out.println("ingrese pos X del nuevo auto");
                    int posx = leer.nextInt();
                    System.out.println("ingrese pos Y del nuevo auto");
                    int posy = leer.nextInt();
                    setAuto(new Auto(posx, posy));
                    break;
            }
            if (choco()){
                System.out.println("Chocaste! ingrese n para cambiar de auto o e para salir");
            }

        } while(!opc.equalsIgnoreCase("e"));
    }
}