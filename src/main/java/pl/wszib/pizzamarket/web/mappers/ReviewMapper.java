package pl.wszib.pizzamarket.web.mappers;

import pl.wszib.pizzamarket.data.entities.ReviewEntity;
import pl.wszib.pizzamarket.web.models.ReviewModel;

public class ReviewMapper {
    public static ReviewEntity toEntity(ReviewModel model) {
        ReviewEntity entity = new ReviewEntity();
        entity.setName(model.getName());
        entity.setReview(model.getReview());

        return entity;
    }

    public static ReviewModel toModel(ReviewEntity entity) {
        return new ReviewModel(
                entity.getName(),
                entity.getReview()
        );
    }
}
