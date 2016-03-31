package sears.myapplication;

/**
 * Created by admin on 3/30/2016.
 */
public class Homework01 {


    // 8 minutos
    public void consecutives ( int a [] ) {

        boolean flag = false ;

        for ( int i = 0 ; i < a.length - 1 ; i++ ) {
            if ( a [i] + 1 == a [i + 1 ] ) {
                System.out.print(flag ? "," : "" + a[i] + ", " + a[i + 1]) ;
                flag = true ;
                i ++ ;
            }
        }

        System.out.println ( ! flag ? "No consecutives" : ""  ) ;
    }

    // 3
    public void reversePrint ( int a [] ) {
        System.out.println("");

        for ( int i = a.length - 1 ; i >= 0 ; i -- )
            System.out.print( a [ i ] + " " );

        System.out.println ( "" );
    }

    public int [] reverseArray ( int a [] ) {
        int b [] = new int [ a.length ] ;

        for ( int i = 0 ; i < a.length ; i ++ )
            b [ i ] = a [ a.length - i - 1 ] ;

        return b ;
    }

    public char [] reverseArray ( char a [] ) {
        char b [] = new char [ a.length ] ;

        for ( int i = 0 ; i < a.length ; i ++ )
            b [ i ] = a [ a.length - i - 1 ] ;

        return b ;
    }


    // 2
    public void minmax ( int a [] ) {

        if ( a == null )
            return ;

        int min = a [ 0 ] ;
        int max = a [ 0 ] ;
        for ( int i = 1 ; i < a.length; i ++ ) {
            if ( a [ i ] < min )
                min = a [ i ];

            if ( a [ i ] > max  )
                max = a [ i ];
        }

        System.out.println ( "Min: " + min + " Max: " + max ) ;
    }

    // 9
    public void palindromo ( char [] a ) {
        char [] b = reverseArray( a ) ;
        if ( same ( a , b ) ) {
            System.out.println("Palindrome: " + new String(a) + " <==> " + new String ( b ) ) ;
        } else
            System.out.println("Not a Palindrome: " + new String(a) + " [[]] " + new String ( b ) ) ;
    }

    public boolean same ( char  [] a  , char b [] ) {
        if ( a == null || b == null )
            return false ;

        if ( a.length != b.length )
            return false ;

        for ( int i = 0 ; i < a.length ; i ++ )
            if ( a [i] != b [i] )
                return false ;

        return true ;
    }

    public int [] getArray ( int size, int max ) {
        int array [] = new int [size] ;

        for ( int i = 0 ; i < size ; i++ ) {
            array [ i ] = (int) ( Math.random() * max ) ;
        }

        return array ;
    }

    public void printArray ( int [] a ) {

        System.out.println("");
        for ( int x : a )
            System.out.print( x + " " );
        System.out.println ( "" );

    }

    public void printArray ( char [] a ) {


        for ( char x : a )
            System.out.print( x );


    }

    public static void main ( String args [] ) {
        Homework01 h = new Homework01 () ;
        int array [ ] = h.getArray(100, 99) ;
        //h.printArray ( array ) ;

        System.out.println("%%%%%%%%%%%%%%%%%%%% CONSECUTIVES %%%%%%%%%%%%%%%%%%%%")  ;

        System.out.println("Round 1 :")  ;
        h.consecutives(h.getArray(100, 99));

        System.out.println("Round 2 :")  ;
        h.consecutives(h.getArray(100, 99));

        System.out.println("Round 3 :")  ;
        h.consecutives(h.getArray(100, 99));


        array = h.getArray( 20, 1000 ) ;

        System.out.println("\n\n%%%%%%%%%%%%%%%%%%%% REVERSE  %%%%%%%%%%%%%%%%%%%%")  ;
        System.out.print("Original:")  ;
        h.printArray(array) ;

        System.out.print("Reverse printing :")  ;
        h.reversePrint(array);

        System.out.print("Reversed array :")  ;
        h.printArray(h.reverseArray(array));


        System.out.println("\n\n%%%%%%%%%%%%%%%%%%%% MIN / MAX  %%%%%%%%%%%%%%%%%%%%")  ;

        h.minmax(array) ;



        System.out.println("\n\n%%%%%%%%%%%%%%%%%%%% PALINDROME  %%%%%%%%%%%%%%%%%%%%")  ;
        String s1 = "anitalavalatina" ;
        h.palindromo(s1.toCharArray());

        s1 = "aNitOlavaClatiNa" ;
        h.palindromo( s1.toCharArray() );



    }
}
