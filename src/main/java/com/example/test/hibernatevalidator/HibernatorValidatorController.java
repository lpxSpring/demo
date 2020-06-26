package com.example.test.hibernatevalidator;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.groups.Default;

/**
 * @author 18124550
 * @date 2019/7/3
 */
@RestController
@RequestMapping("/validator")
@Validated
public class HibernatorValidatorController extends GlobalExceptionHandler {
    /**
     * 适用接口
     * @param payRequestDto
     * @return
     */
    @RequestMapping(value = "/hibernator", method = RequestMethod.POST)
    public String ValidatorTest(@RequestBody PayRequestDto payRequestDto) {
        ValidationResult validationResult = ValidationUtils.validateEntity(payRequestDto, Default.class);
        if (null != validationResult) {
            return validationResult.toString();
        }
        return payRequestDto.getPayTime() + "--" + payRequestDto.getStatus();
    }

    /**
     *   适用页面请求
     * @param payRequestDto
     * @return
     */
    @RequestMapping(value = "/hibernator1", method = RequestMethod.POST)
    public String ValidatorTest1(@RequestBody @Valid PayRequestDto payRequestDto, BindingResult bindingResult) {
        return payRequestDto.getPayTime() + "--" + payRequestDto.getStatus();
    }

    /**
     *   适用页面请求 2
     * @param payRequestDto
     * @return
     */
    @RequestMapping(value = "/hibernator11", method = RequestMethod.POST)
    public String ValidatorTest11(@RequestBody @Valid PayRequestDto payRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuffer sb = new StringBuffer();
           for (ObjectError objectError : bindingResult.getAllErrors()) {
               sb.append(((FieldError) objectError).getField() + " : ").append(objectError.getDefaultMessage());
           }

           return sb.toString();
        }

        return payRequestDto.getPayTime() + "--" + payRequestDto.getStatus();
    }

    @RequestMapping(value = "/hibernator2", method = RequestMethod.GET)
    public String ValidatorTest2(@Valid PayRequestDto payRequestDto) {

        return payRequestDto.getPayTime() + "--" + payRequestDto.getStatus();
    }

    @RequestMapping(value = "/hibernator3", method = RequestMethod.GET)
    public String ValidatorTest3(@NotEmpty @RequestParam("payTime") String payTime,@NotEmpty @RequestParam("status") String status) {

        return payTime + "--" + status;
    }
}
