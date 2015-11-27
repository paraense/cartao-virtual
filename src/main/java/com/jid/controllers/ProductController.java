package com.jid.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jid.models.Category;
import com.jid.daos.CategoryDao;
import com.jid.daos.ProductDao;
import com.jid.models.Product;

@Controller
@RequestMapping("/product")
@Transactional
public class ProductController
{

   @Autowired
   private ProductDao productDao;
   @Autowired
   private CategoryDao categoryDao;

   @RequestMapping("/form")
   public ModelAndView form(Product product)
   {
      ModelAndView modelAndView = new ModelAndView("product/form-add");
      return loadFormDependencies(modelAndView);

   }

   private ModelAndView loadFormDependencies(ModelAndView modelAndView)
   {
      modelAndView.addObject("categoryList", categoryDao.all());
      return modelAndView;
   }

   @RequestMapping(method = RequestMethod.POST)
   public ModelAndView save(@Valid Product product, BindingResult bindingResult)
   {
      if (bindingResult.hasErrors())
      {
         return form(product);
      }
      productDao.save(product);
      return new ModelAndView("redirect:/product");
   }

   @RequestMapping(method = RequestMethod.GET, value = "/{id}")
   public ModelAndView load(@PathVariable("id") Integer id)
   {
      ModelAndView modelAndView = new ModelAndView("product/form-update");
      modelAndView.addObject("product", productDao.findById(id));
      loadFormDependencies(modelAndView);
      return modelAndView;
   }

   @RequestMapping(method = RequestMethod.GET)
   public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page)
   {
      ModelAndView modelAndView = new ModelAndView("product/list");
      modelAndView.addObject("paginatedList", productDao.paginated(page, 10));
      return modelAndView;
   }

   //just because get is easier here. Be my guest if you want to change.
   @RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
   public String remove(@PathVariable("id") Integer id)
   {
      Product product = productDao.findById(id);
      productDao.remove(product);
      return "redirect:/product";
   }

   @RequestMapping(method = RequestMethod.POST, value = "/{id}")
   public ModelAndView update(@PathVariable("id") Integer id, @Valid Product product, BindingResult bindingResult)
   {
      product.setId(id);
      if (bindingResult.hasErrors())
      {
         return loadFormDependencies(new ModelAndView("product/form-update"));
      }
      productDao.update(product);
      return new ModelAndView("redirect:/product");
   }
}
