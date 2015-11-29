package com.jid.controllers;

import javax.validation.Valid;

import com.jid.daos.ProductRepository;
import com.jid.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.jid.models.Category;
import com.jid.daos.CategoryDao;

@Controller
@RequestMapping("/category")
@Transactional
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/form")
    public ModelAndView form(Category category) {
        ModelAndView modelAndView = new ModelAndView("category/form-add");
        return modelAndView;

    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@Valid Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return form(category);
        }
        categoryDao.save(category);
        return new ModelAndView("redirect:/category");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ModelAndView load(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("category/form-update");
        modelAndView.addObject("category", categoryDao.findById(id));
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
        ModelAndView modelAndView = new ModelAndView("category/list");
        modelAndView.addObject("paginatedList", categoryDao.paginated(page, 10));
        return modelAndView;
    }

    //just because get is easier here. Be my guest if you want to change.
    @RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        Category category = categoryDao.findById(id);
        categoryDao.remove(category);
        return "redirect:/category";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}")
    public ModelAndView update(@PathVariable("id") Integer id, @Valid Category category, BindingResult bindingResult) {
        category.setId(id);
        if (bindingResult.hasErrors()) {
            return new ModelAndView("category/form-update");
        }
        categoryDao.update(category);
        return new ModelAndView("redirect:/category");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/gogo")
    @ResponseBody
    public Product gogo() {
        return productRepository.findByName("Aaa");
    }
}
