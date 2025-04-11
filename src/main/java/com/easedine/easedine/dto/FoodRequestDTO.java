package com.easedine.easedine.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Data
@Getter
@Setter
public class FoodRequestDTO {
        private String name;
        private String description;
        private double price;
        private String category;
        private String restaurantId;
        private MultipartFile image;


        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public double getPrice() {
                return price;
        }

        public void setPrice(double price) {
                this.price = price;
        }

        public String getCategory() {
                return category;
        }

        public void setCategory(String category) {
                this.category = category;
        }

        public String getRestaurantId() {
                return restaurantId;
        }

        public void setRestaurantId(String restaurantId) {
                this.restaurantId = restaurantId;
        }

        public MultipartFile getImage() {
                return image;
        }

        public void setImage(MultipartFile image) {
                this.image = image;
        }
}
