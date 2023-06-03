package alken1t.runtime.kz.springpractice_9_00.service.pro;

import alken1t.runtime.kz.springpractice_9_00.entity.Product;
import alken1t.runtime.kz.springpractice_9_00.entity.Reviews;
import alken1t.runtime.kz.springpractice_9_00.entity.Users;
import alken1t.runtime.kz.springpractice_9_00.repository.ReviewsRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewsService {
    private final ReviewsRepository reviewsRepository;

    public double getRating(long id){
        int count = reviewsRepository.getCountForRating(id);
        if (count==0){
            return 0.0;
        }
        int rating = reviewsRepository.getRating(id);
        return (double) rating /count;
    }

    public Reviews findByProduct(Product product){
        return reviewsRepository.findByProduct(product);
    }

    public Reviews findByProductAndUser(Product product, Users user){
        return reviewsRepository.findByProductAndUser(product,user);
    }

    public void save(Reviews reviews){
        reviewsRepository.save(reviews);
    }
}