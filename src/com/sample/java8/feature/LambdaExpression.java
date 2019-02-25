package com.sample.java8.feature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JButton;

public class LambdaExpression
{
    public static void main( String[] args )
    {
        List<String> languages = Arrays.asList( "Java", "C++","Scala","DotNet", "C-Language", "Helo", "JSca" );
        /*noLambdaExpression1(languages);
        lambdaExpressionReplacesAnonymousClass(languages);
        
        noLambdaExpression2(languages);
        lambdaExpression2(languages);
        
        noLambdaExpression3(languages);
        lambdaExpressionMethodReferenceFeature(languages);
        
        lambdaExpressionFilter(languages);
        
        System.out.println( "Languages starting with J and length equals 4 are:" );
        combinePredicateInLambda(languages);
        
        noLambdaListCalculation();
        lambdaWithListCalculationExample();
        
        mapReduceExampleWithNoLambda();
        mapReduceExampleWithLambda();
        
        filterCollectionUsingLambdaCollectors();
        
        lambdaApplyFunctionOnEachElementOfAList();
        
        lambdaUseDistinctToAvoidDuplicate();
        
        lambdaGetSummaryStats();
        
        lambdaSortPrimitive();*/
        
        lambdaSortObject();
        
        parallelStream();
    }

    private static void parallelStream()
    {
        List<Integer> myList = new ArrayList<>();
        for(int i=0; i<1000; i++) myList.add(i);
        
        //sequential stream
        Stream<Integer> sequentialStream = myList.stream();
        
        //parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();
        
        //parallel Streaming
        Long startTime = System.currentTimeMillis();
        System.out.println( startTime );
        Stream<Integer> highNums = parallelStream.filter(p -> p > 5);
        //using lambda in forEach
        highNums.forEach(p -> System.out.print("High Nums parallel="+p));
        Long endTime = System.currentTimeMillis();
        System.out.println( "End Time:"+endTime );
        Long totalTime = endTime-startTime;
        System.out.println( "Total time Parallel:"+totalTime );
        
        //Sequential Streaming
        Long startTime1 = System.currentTimeMillis();
        System.out.println( startTime1 );
        Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 5);
        
        highNumsSeq.forEach(p -> System.out.print("High Nums sequential="+p));
        Long endTime1 = System.currentTimeMillis();
        System.out.println( "End Time:"+endTime1 );
        Long totalTime1 = endTime1-startTime1;
        System.out.println( "Total time sequential:"+totalTime1 );
}
        
    private static void lambdaSortObject()
    {
        Student lStudent1 = new Student(1,30,"Manish");
        Student lStudent2 = new Student(3,37,"Shubhra");
        Student lStudent3 = new Student(2,34,"Vijaya");
        Student lStudent4 = new Student(4,27,"Rupa");
        
        List<Student> lStudents = new ArrayList<>();
        lStudents.add( lStudent1 );
        lStudents.add( lStudent2 );
        lStudents.add( lStudent3 );
        lStudents.add( lStudent4 );
        
        System.out.println( "Sort by Name default ascending order:" );
        List<Student> lDefaultSorted = lStudents.stream().sorted().collect( Collectors.toList() );
        lDefaultSorted.forEach( s-> System.out.println( "Id:"+s.getId() +", Name:"+s.getName()+ ", Age:"+s.getAge() ) );
        
        System.out.println( "Sort by Name reverse order:" );
        List<Student> lReverseOrder = lStudents.stream().sorted(Comparator.reverseOrder()).collect( Collectors.toList() );
        lReverseOrder.forEach( s-> System.out.println( "Id:"+s.getId() +", Name:"+s.getName()+ ", Age:"+s.getAge() ) );
        
        System.out.println( "Sort By Age:" );
        List<Student> lSortByAge = lStudents.stream().sorted( Comparator.comparing( Student::getAge ) ).collect( Collectors.toList() );
        lSortByAge.forEach( s-> System.out.println( "Id:"+s.getId() +", Name:"+s.getName()+ ", Age:"+s.getAge() ) );
        
        System.out.println( "Sort by Age in reverse order:" );
        List<Student> lSortedAgeReverse = lStudents.stream().sorted(Comparator.comparing( Student::getAge ).reversed()).collect( Collectors.toList() );
        lSortedAgeReverse.forEach( s->System.out.println(  "Id:"+s.getId() +", Name:"+s.getName()+ ", Age:"+s.getAge() ) );
        
        System.out.println( "Sort by Id in ascending order:" );
        List<Student> lSortedIdAscending = lStudents.stream().sorted(Comparator.comparing( Student::getId )).collect( Collectors.toList() );
        lSortedIdAscending.forEach( s->System.out.println(  "Id:"+s.getId() +", Name:"+s.getName()+ ", Age:"+s.getAge() ) );
        
        System.out.println( "Sort by Id in reverse order:" );
        List<Student> lSortedIdReverse = lStudents.stream().sorted(Comparator.comparing( Student::getId ).reversed()).collect( Collectors.toList() );
        lSortedIdReverse.forEach( s->System.out.println(  "Id:"+s.getId() +", Name:"+s.getName()+ ", Age:"+s.getAge() ) );
    }

    private static void lambdaSortPrimitive()
    {
        List<Integer> lListOriginal = Arrays.asList(7,2,5,3,8,23  );
        System.out.println( "Original List:"+lListOriginal );
        List<Integer>  lDefaultSortedList = lListOriginal.stream().sorted().collect( Collectors.toList() );
        System.out.println( "Default sort list:"+lDefaultSortedList );
        List<Integer> lReverseOrderList = lListOriginal.stream().sorted( Comparator.reverseOrder()).collect( Collectors.toList() );
        System.out.println( "Reverse Order List:"+lReverseOrderList );
    }

    private static void lambdaGetSummaryStats()
    {
        List<Integer> lNumbers = Arrays.asList( 3,1,5,6,5,1,3 );
        System.out.println( "\nOriginal Numbers:"+lNumbers );
        IntSummaryStatistics lIntSummaryStats = lNumbers.stream().mapToInt( x->x ).summaryStatistics();
        System.out.println( "Max number in the list:"+lIntSummaryStats.getMax() );
        System.out.println( "Min number in the list:"+lIntSummaryStats.getMin() );
        System.out.println( "Sum of all numbers in the list:"+lIntSummaryStats.getSum() );
        System.out.println( "Avg of all numbers in the list:"+lIntSummaryStats.getAverage() );
    }

    private static void lambdaUseDistinctToAvoidDuplicate()
    {
        List<Integer> lNumbers = Arrays.asList( 3,1,5,6,5,1,3 );
        System.out.println( "\nOriginal List of integers:"+lNumbers );
        List<Integer>  lDistinctSquares = lNumbers.stream().map( x->x*x ).distinct().collect( Collectors.toList() );
        System.out.println( "After removing duplicates the square of each number are:"+lDistinctSquares );
        //Sort the above list
        List<Integer> lSortedList = lDistinctSquares.stream().sorted().collect( Collectors.toList() );
        System.out.println( "Sorted List default order: "+lSortedList );
        
        //Sort in reverse order
        List<Integer> lSortListReverseOrder = lSortedList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()  );
        System.out.println( "Sorted List in reverse order:"+ lSortListReverseOrder );
    }

    private static void lambdaApplyFunctionOnEachElementOfAList()
    {
        List<String> lCountries = Arrays.asList( "india","JaPan","Mexico","NepaL" );
        System.out.println( "\nOriginal Countries:"+lCountries );
        String lCountriesConverted = lCountries.stream().map( x->x.toUpperCase() ).collect( Collectors.joining( "," ) );
        System.out.println( "Countries converted to UpperCase:"+lCountriesConverted );
        
    }

    private static void filterCollectionUsingLambdaCollectors()
    {
        List<String> lList = Arrays.asList( "abc","def","gh","ijk" );
        System.out.println( "\nOriginal List: "+lList );
        List<String> lFiltered = lList.stream().filter( x->x.length()>2 ).collect( Collectors.toList() );
        System.out.println( "Filtered List:"+lFiltered );
    }

    private static void mapReduceExampleWithLambda()
    {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax.stream().map( (cost )->cost+.12*cost).reduce(( sum, cost )->sum+cost).get();
        System.out.println( "Total Bill:"+bill );
    }

    private static void mapReduceExampleWithNoLambda()
    {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double totalCost = 0;
        for( Integer cost : costBeforeTax )
        {
            double price = cost + .12*cost;
            totalCost = totalCost + price;
        }
        System.out.println( "With no map reduce lambda==> Total:"+totalCost );
    }

    private static void noLambdaListCalculation()
    {
        System.out.println( "With No Lambda added 12% vat to each element of list:" );
        List<Integer> costBeforeTax = Arrays.asList( 100, 200, 300, 400, 500 );
        for( Integer cost : costBeforeTax )
        {
            double price = cost + .12 * cost;
            System.out.println( price );
        }
    }

    private static void lambdaWithListCalculationExample()
    {
        System.out.println( "\nWith Lambda added 12% vat to each element of list:" );
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map( (cost )-> cost+.12*cost).forEach( System.out::println );

    }

    private static void lambdaExpressionFilter(List<String> languages)
    {
        System.out.println( "\nLanguages which start with C :" );
        filter(languages, (str)->str.startsWith( "C" ));
        
        System.out.println( "\nLanguages which ends with + is" );
        filter(languages, (str)->str.endsWith( "+" ));
        
        System.out.println( "\nPrint all languages:" );
        filter( languages, ( str)->true );
        
        System.out.println( "\nPrint no languages:" );
        filter( languages, (str)->false );
        
        System.out.println( "\nPrint languages whose length is > 4 :" );
        filter(languages, (str)->str.length()>4);
        
        //Filter with stream
        //call filter1
    }
    
    private static void combinePredicateInLambda( List<String> languages )
    {
        Predicate<String> startWithJ = (n) -> n.startsWith( "J" );
        Predicate<String> lengthIsFour = (n) -> n.length() == 4;
        
        languages.stream().filter( startWithJ.and( lengthIsFour )).forEach( n->{
            System.out.println( n );
        });
    }

    private static void filter1( List<String> languages,
                                Predicate<String> condition )
    {
        languages.stream().filter( (name)->(condition.test( name )) ).forEach( (name)-> {
          System.out.println( name );  
        });
    }

    private static void filter( List<String> languages,
                                Predicate<String> condition )
    {
        for( String name : languages )
        {
            if(condition.test( name ))
            {
                System.out.println( name );
            }
        }
    }

    private static void lambdaExpressionMethodReferenceFeature(List<String> languages)
    {
        List<String> features = Arrays.asList( "Manish","Subhra","Vijaya" );
        System.out.println( "\nInside lambda expression3." );
        features.forEach( n->System.out.println( n  ) );
        
        //same output as above
        System.out.println( "Inside lambda expression3." );
        features.forEach(System.out::println);
    }

    private static void noLambdaExpression3(List<String> languages)
    {
        List<String> features = Arrays.asList( "Manish","Subhra","Vijaya" );
        System.out.println( "\nInside no lambda expression3." );
        for( String feature : features )
        {
            System.out.println( feature );
        }
    }

    private static void lambdaExpression2(List<String> languages)
    {
        JButton show = new JButton("Show");
        show.addActionListener( ( e ) -> {
            System.out.println( "In java8 lambda expression2" );
            System.out.println();
        } );
    }

    private static void noLambdaExpression2(List<String> languages)
    {
        JButton  show = new JButton( "Show" );
        show.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed( ActionEvent e )
            {
                System.out.println( "Before java8." );
            }
        } );
    }
    
    private static void noLambdaExpression21(List<String> languages)
    {
        new SampleInterfaceImpl(new ActionListenerIface()
        {
            
            @Override
            public void event()
            {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void method1( String str )
            {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void method1()
            {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void actionPerformed( ActionEvent e )
            {
                // TODO Auto-generated method stub
                
            }
        });
    }
    
    private static void noLambdaExpression22(List<String> languages)
    {/*
        new SampleInterfaceImpl((e)->{
            System.out.println("");
        });
    */}
    
    private static void lambdaExpressionReplacesAnonymousClass(List<String> languages)
    {
        new Thread(() -> System.out.println( "In java8 lambda expression1." )).start();
    }

    private static void noLambdaExpression1(List<String> languages)
    {
        new Thread( new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println( "Before java8." );
            }
        } ).start();
    }
}
