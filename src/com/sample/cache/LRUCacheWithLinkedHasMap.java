package com.sample.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheWithLinkedHasMap extends LinkedHashMap<Integer, String>
{
    private static final long serialVersionUID = 1L;
    private int capacity;

    public LRUCacheWithLinkedHasMap( int capacity,
        float loadFactor )
    {
        super( capacity, loadFactor, true );
        this.capacity = capacity;
    }

    /**
     * removeEldestEntry() should be overridden by the user, 
     * this removes the oldest object from the Map.
     */
    @Override
    protected boolean removeEldestEntry( Map.Entry<Integer, String> eldest )
    {
        return size() > this.capacity;
    }

    public static void main( String arg[] )
    {
        LRUCacheWithLinkedHasMap lruCache = new LRUCacheWithLinkedHasMap( 4, 0.75f );

        lruCache.put( 1, "Object1" );//1
        lruCache.put( 2, "Object2" );// 1 2
        lruCache.put( 3, "Object3" );// 1 2 3
        lruCache.get( 1 );// 2 3 1
        lruCache.put( 4, "Object4" );// 2 3 1 4
        System.out.println( lruCache );// 2 3 1 4
        lruCache.put( 5, "Object5" );// 3 1 4 5
        lruCache.get( 3 );// 1 4 5 3
        lruCache.put( 6, "Object6" );// 4 5 3 6
        System.out.println( lruCache );//4 5 3 6
        lruCache.get( 4 );// 5 3 6 4
        lruCache.put( 7, "Object7" );//3 6 4 7
        lruCache.put( 8, "Object8" );//6 4 7 8
        System.out.println( lruCache );//6 4 7 8
    }
}

