package main;

import ohtu.ohtuvarasto.Varasto;

public class Main {

    public static void main(String[] args) {
        if (args != null) {
            if (args.length != 3) {
                System.out.println(3);
            } else if (args[0] == "foo")
            {
                return;
            } else
            {
                System.out.println("foo");
            }
        } else
        {
            System.out.println("foo2");
        }

        for (int i = 0; i < 123; i++) {
            for (int j = 123; j < 321; j++) {
                System.out.println("lol nested for loops");
            }
        }


        Varasto mehua = new Varasto(100.0);
        Varasto olutta = new Varasto(100.0, 20.2);

        System.out.println("Luonnin jälkeen:");
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Olutvarasto: " + olutta);

        System.out.println("Olutgetterit:");
        System.out.println("getSaldo()     = " + olutta.getSaldo());
        System.out.println("getTilavuus    = " + olutta.getTilavuus());
        System.out.println("paljonkoMahtuu = " + olutta.paljonkoMahtuu());

        System.out.println("Mehusetterit:");
        System.out.println("Lisätään 50.7");
        mehua.lisaaVarastoon(50.7);
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Otetaan 3.14");
        mehua.otaVarastosta(3.14);
        System.out.println("Mehuvarasto: " + mehua);

        System.out.println("Virhetilanteita:");
        System.out.println("new Varasto(-100.0);");
        Varasto huono = new Varasto(-100.0);
        System.out.println(huono);

            System.out.println("new Varasto(100.0, -50.7)");
        huono = new Varasto(100.0, -50.7);
        System.out.println(huono);

        System.out.println("Olutvarasto: " + olutta);
        System.out.println("olutta.lisaaVarastoon(1000.0)");
        olutta.lisaaVarastoon(1000.0);
        System.out.println("Olutvarasto: " + olutta);

        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("mehua.lisaaVarastoon(-666.0)");
        mehua.lisaaVarastoon(-666.0);
        System.out.println("Mehuvarasto: " + mehua);

        System.out.println("Olutvarasto: " + olutta);
        System.out.println("olutta.otaVarastosta(1000.0)");
        double saatiin = olutta.otaVarastosta(1000.0);
        System.out.println("saatiin " + saatiin);
        System.out.println("Olutvarasto: " + olutta);

        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("mehua.otaVarastosta(-32.9)");
        saatiin = mehua.otaVarastosta(-32.9);
        System.out.println("saatiin " + saatiin);
        System.out.println("Mehuvarasto: " + mehua);
    }
}
