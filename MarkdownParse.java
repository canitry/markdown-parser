//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }

    static String innerParen(String markdown, int openParen, int closeParen, int trueOpen){
        System.out.println(markdown + trueOpen + closeParen);
        int innerparen = markdown.substring(openParen+1, closeParen).indexOf("(");
        if (innerparen == -1){
            // toReturn.add(markdown.substring(openParen+1, closeParen));
//            System.out.println(markdown + trueOpen + "close: " + closeParen);
            return markdown.substring(trueOpen+1, closeParen);
        }
        else{
            while (innerparen != -1){
                innerparen = innerparen + 1 + openParen;
                int prevcloseParen = closeParen;
                System.out.println(closeParen + "hiro");
                closeParen = markdown.substring(closeParen+1).indexOf(")");
                if (closeParen != -1){
                    closeParen += prevcloseParen + 1;
//                    System.out.println(closeParen+"readded");
                    return innerParen(markdown, innerparen, closeParen, trueOpen);
                }
                else{
                    return null;
                }
            }
        }
        return null;
    }

    static String innerBracket(String markdown, int openBracket, int closeBracket, int openParen){
        char exc = '!';
        int innerBracket = markdown.substring(openBracket,closeBracket).lastIndexOf("]");
        if (innerBracket == -1){
            if (openBracket == 0 || markdown.charAt(openBracket-1) != exc){
                int closeParen = markdown.indexOf(")", openParen);
                if (closeParen != -1){
                    
//                    System.out.println(markdown + "  hri close paren  " +closeParen + "   open paren + 1  "+ openParen);
                    return innerParen(markdown, openParen, closeParen, openParen);
                }else{
                    return null;
                }
            }
        }
        else{
            while (innerBracket != -1){
                openBracket = markdown.substring(0,openBracket).lastIndexOf("[");
                if (openBracket != -1){
                    return innerBracket(markdown, openBracket, innerBracket, openParen);
                }else{
                    return null;
                }
            }
        }
        return null;
    }

    public static ArrayList<String> getLinks(String markdown) {
        char exc = '!';
        char par = '(';
        int closeBracket = 0;
        ArrayList<String> toReturn = new ArrayList<>();
        while (closeBracket != -1){
            //            int prevCB = closeBracket;
            closeBracket = markdown.indexOf("]", closeBracket+1);
            if (markdown.charAt(closeBracket+1) == par){
                int openParen = closeBracket+1;
                int openBracket = markdown.substring(0,closeBracket).lastIndexOf("[");
                if (openBracket != -1){
                    String element = innerBracket(markdown, openBracket, closeBracket, openParen);
                    if (element != null){
                        toReturn.add(element);
                    }
                }
            }
        }
        return toReturn;
                // boolean mainobpresent = false;
        // int obpresent = 0;
        // boolean mainoppresent = false;
        // int oppresent = 0;
        // ArrayList<String> toReturn = new ArrayList<>();
        // // find the next [, then find the ], then find the (, then read link upto next )
        // int currentIndex = 0;
        // //System.out.println("eyo my dude this is something");
        // while(currentIndex < markdown.length()) {
        //     int openBracket = markdown.indexOf("[", currentIndex);
        //     int mainOB=openBracket;
        //     if (mainobpresent == false){
        //         mainobpresent = true;
        //         mainOB = openBracket;
        //         System.out.println("there" + mainOB+" what " + markdown);
        //     }else{
        //         obpresent++;
        //     }
        //     if (openBracket == -1){
        //         break;
        //     }
        //     int closeBracket = -1;
        //     int mainCB=closeBracket;
        //     int searchfromb = openBracket;
        //     while (mainobpresent){
        //         closeBracket = markdown.indexOf("]", searchfromb);
        //         if (closeBracket == -1){
        //             break;
        //         }
        //         if (obpresent == 0){
        //             mainobpresent = false;
        //             mainCB = closeBracket;
        //             System.out.println("there" + mainCB+" what " + markdown);
        //         }else{
        //             obpresent--;
        //             searchfromb = closeBracket;
        //         }
        //     }
        //     if (closeBracket == -1){
        //         break;
        //     }
        //     int openParen = markdown.indexOf("(", closeBracket);
        //     int mainOP=openParen;
        //     if (mainoppresent == false){
        //         mainoppresent = true;
        //         mainOP = openParen;
        //     }else{
        //         oppresent++;
        //     }
        //     if (openParen == -1){
        //         break;
        //     }
        //     int closeParen = -1;
        //     int mainCP=closeParen;
        //     int searchfromp = openParen;
        //     if (mainCB + 1 == mainOP){
        //         while (mainoppresent){
        //             closeParen = markdown.indexOf(")", searchfromp);
        //             if (closeParen == -1){
        //                 break;
        //             }
        //             if (oppresent == 0){
        //                 mainoppresent = false;
        //                 mainCP = closeParen;
        //             }else{
        //                 obpresent--;
        //                 searchfromp = closeParen;
        //             }
        //         }
        //         if (closeParen == -1){
        //             break;
        //         }
        //         if (openBracket == 0 ||markdown.charAt(mainOB-1)!= exc){
        //             toReturn.add(markdown.substring(mainOP + 1, mainCP));
        //         }
        //     }
        //     else{
        //         closeParen = openParen;
        //     }
        //     currentIndex = closeParen + 1;
        //     // System.out.println("updated" + currentIndex);
        //     // System.out.println("markdown" + markdown.length());
        // }

        // return toReturn;
    }
}
