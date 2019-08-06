package com.example.samazon.Repositories;

import com.example.samazon.Beans.History;
import com.example.samazon.Beans.User;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepository extends CrudRepository<History, Long> {
    History findByUser(User user);
}
