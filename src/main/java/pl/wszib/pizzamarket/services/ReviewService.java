package pl.wszib.pizzamarket.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.wszib.pizzamarket.data.entities.ReviewEntity;
import pl.wszib.pizzamarket.data.repositories.ReviewRepository;
import pl.wszib.pizzamarket.web.mappers.ReviewMapper;
import pl.wszib.pizzamarket.web.models.ReviewModel;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    @Transactional
    public void saveReview(ReviewModel reviewModel) {

        ReviewEntity reviewEntity = ReviewMapper.toEntity(reviewModel);

        reviewRepository.save(reviewEntity);
    }

    /*public ReviewModel getAllReviews() {

        List<ReviewEntity> reviewEntity = reviewRepository.findAll();

        return ReviewMapper.toModel((ReviewEntity) reviewEntity);
    }*/
    public List<ReviewModel> findAll() {
        List<ReviewEntity> entities = reviewRepository.findAll();

        return entities.stream()
                .map(ReviewMapper::toModel)
                .toList();
    }
}
