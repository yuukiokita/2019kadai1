package itecafe;

import java.util.Scanner;

public class ITEcafe {

    public static void main(String[] args) {
        Item Hotcoffee = new Item(1, "ホットコーヒー", 280);
        Item tea = new Item(2, "紅茶", 260);
        Item icecoffee = new Item(3, "アイスコーヒー", 200);
        Item icetea = new Item(4, "アイスティー", 260);
        Item OrangeJuice = new Item(5, "オレンジジュース", 180);
        Item Soda = new Item(6, "ソーダ", 180);
        Item shortCake = new Item(7, "ショートケーキ", 400);
        Item cheeseCake = new Item(8, "チーズケーキ", 400);
        Item chocolateCake = new Item(9, "チョコレートケーキ", 450);
        Item chocoBananaPuff = new Item(10, "チョコバナナパフェ", 390);
        Item strawberryPuff = new Item(11, "イチゴパフェ", 390);
        Item meatPasta = new Item(12, "ミートパスタ", 650);
        Item mixPasta = new Item(13, "ミックスパスタ", 700);
        Item croissant = new Item(14, "クロワッサン", 180);
        Item toastSandwich = new Item(15, "トーストサンド", 200);
        Item frenchToast = new Item(16, "フレンチトースト", 210);

        Item[] items = new Item[20];
        items[0] = Hotcoffee;
        items[1] = tea;
        items[2] = icecoffee;
        items[3] = icetea;
        items[4] = OrangeJuice;
        items[5] = Soda;
        items[6] = shortCake;
        items[7] = cheeseCake;
        items[8] = chocolateCake;
        items[9] = chocoBananaPuff;
        items[10] = strawberryPuff;
        items[11] = meatPasta;
        items[12] = mixPasta;
        items[13] = croissant;
        items[14] = toastSandwich;
        items[15] = frenchToast;
        while (true) {
            System.out.println("<ITEカフェシステム>");
            System.out.println("《ドリンク》");
            System.out.println(Hotcoffee.getNum() + ":" + Hotcoffee.getName());
            System.out.println(tea.getNum() + ":" + tea.getName());
            System.out.println(icecoffee.getNum() + ":" + icecoffee.getName());
            System.out.println(icetea.getNum() + ":" + icetea.getName());
            System.out.println(OrangeJuice.getNum() + ":" + OrangeJuice.getName());
            System.out.println(Soda.getNum() + ":" + Soda.getName());
            System.out.println("《スイーツ》");
            System.out.println(shortCake.getNum() + ":" + shortCake.getName());
            System.out.println(cheeseCake.getNum() + ":" + cheeseCake.getName());
            System.out.println(chocolateCake.getNum() + ":" + chocolateCake.getName());
            System.out.println(chocoBananaPuff.getNum() + ":" + chocoBananaPuff.getName());
            System.out.println(strawberryPuff.getNum() + ":" + strawberryPuff.getName());
            System.out.println("《軽食》");
            System.out.println(meatPasta.getNum() + ":" + meatPasta.getName());
            System.out.println(mixPasta.getNum() + ":" + mixPasta.getName());
            System.out.println("《パン》");
            System.out.println(croissant.getNum() + ":" + croissant.getName());
            System.out.println(toastSandwich.getNum() + ":" + toastSandwich.getName());
            System.out.println(frenchToast.getNum() + ":" + frenchToast.getName());
            int sum = 0;
            final double tax = 0.08;
            while (true) {
                //商品番号を表示する
                System.out.println("商品番号を入力してください");

                Scanner scan = new Scanner(System.in);
                int inputNum;//商品番号
                int inputQan;//数量

                while (true) {
                    try {
                        String inputStr;
                        inputStr = scan.next();
                        inputNum = Integer.parseInt(inputStr);

                        //数量を表示
                        System.out.println("数量を入力してください");
                        String inputSum;
                        inputSum = scan.next();//数量を入力
                        inputQan = Integer.parseInt(inputSum);//int型に変換
                        //商品の値段×商品の数量
                        System.out.println(items[inputNum - 1].getNum() + ":" + items[inputNum - 1].getName()
                                + " " + items[inputNum - 1].getPrice() * inputQan + "円");
                        //税抜きの値段の合計
                        sum += items[inputNum - 1].getPrice() * inputQan;

                    } catch (NumberFormatException e) {
                        System.out.println("正しく入力してください。");

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("正しく入力してください");
                    } catch (NullPointerException e) {
                        System.out.println("正しく入力してください");
                    }
                    //会計を終了するかどうか
                    System.out.println("会計をしますか？　1：はい　2：いいえ");
                    String end = new java.util.Scanner(System.in).next();//選択肢から入力する
                    int END;
                    try {
                        END = Integer.parseInt(end);//文字列型のendをint型に変換
                        if (END == 1) {
                            //割引券を持っているかどうか
                            System.out.println("割引券はお持ちですか？　1:はい　2:いいえ");
                            String have = new java.util.Scanner(System.in).next();
                            int HAVE;
                            try {
                                //文字列型のendをint型に変換
                                HAVE = Integer.parseInt(have);
                                if (HAVE == 1) {
                                    sum -= sum * 0.05;//割引券で5％引き

                                }
                            } catch (NumberFormatException e) {
                                System.out.println("正しく入力してください。");
                            }

                            break;
                        } else {
                            System.out.println("商品番号を入力してください");

                        }
                    } catch (NumberFormatException e) {
                        System.out.println("正しく入力してください。");
                    }

                }
                break;
            }
            sum += sum * tax;
            System.out.println("会計は" + sum + "円になります");
            while (true) {
                System.out.println("お客様の支払金額を入力してください");
                int pay = new java.util.Scanner(System.in).nextInt();
                int returnPay;
                returnPay= pay - sum;
                if ( returnPay== 0) {
                    System.out.println(pay + "円ちょうどお預かりします");
                    System.out.println("レシートをお渡しします");
                    System.out.println("ありがとうございました");
                    break;
                } else if (returnPay < 0) {
                    System.out.println("金額が足りません");
                } else {
                    System.out.println(returnPay + "円のお返しです");
                    System.out.println("レシートをお渡しします");
                    System.out.println("ありがとうざいました。");
                    break;
                }

            }
        }
    }
}
