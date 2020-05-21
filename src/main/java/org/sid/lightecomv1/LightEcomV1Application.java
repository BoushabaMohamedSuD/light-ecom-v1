package org.sid.lightecomv1;

import net.bytebuddy.utility.RandomString;
import org.sid.lightecomv1.dao.CategoryRepository;
import org.sid.lightecomv1.dao.ProductRepository;
import org.sid.lightecomv1.entities.Category;
import org.sid.lightecomv1.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class  LightEcomV1Application  implements CommandLineRunner {

  @Autowired
    private ProductRepository productRepository;
  @Autowired
    private CategoryRepository categoryRepository;



    public static void main(String[] args) {
        SpringApplication.run(LightEcomV1Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        categoryRepository.save(new Category(null,"Computers",null,null,null));
        categoryRepository.save(new Category(null,"Printers",null,null,null));
        categoryRepository.save(new Category(null,"Smart phones",null,null,null));


        Random rnd= new Random();

        categoryRepository.findAll().forEach(category -> {
            for (int i=0;i<10;i++){
                Product p =new Product();
                p.setName(RandomString.make(10));
                p.setCurrentprice(100+rnd.nextInt(10000));
                p.setAvailable(rnd.nextBoolean());
                p.setPromotion(rnd.nextBoolean());
                p.setSelected(rnd.nextBoolean());
                p.setCategory(category);
                p.setPhotoName("unknown.png");
                productRepository.save(p);


               
            }
        });


    }



}