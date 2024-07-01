package telran.interviews;

import java.util.*;

public class ConnectionPool {
    private final int maxCapacity;
    private final LinkedHashMap<Long, Connection> mapa;

    public ConnectionPool(int size) {
        this.maxCapacity = size;
        this.mapa = new LinkedHashMap<>(size, 0.75f, true) {
            
            @Override
            protected boolean removeEldestEntry(Map.Entry<Long, Connection> eldest) {
                return size() > maxCapacity;
            }
        };
    }

    public Connection getConnection(Connection connection) {
        long id = connection.id();
        return mapa.computeIfAbsent(id, k -> new Connection(id));
    }

    public boolean isInPool(long id) {
        return mapa.containsKey(id);
    }
}

