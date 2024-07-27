package sixthsense.backend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sixthsense.backend.dto.BaseResponseDto;
import sixthsense.backend.dto.menuDto.MenuResponse;
import sixthsense.backend.dto.paymentDto.PaymentResponse;
import sixthsense.backend.dto.promo.PromoResponse;
import sixthsense.backend.service.DataService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/list")
public class DataController {

    private final DataService dataService;

    @GetMapping("/menu")
    private ResponseEntity<BaseResponseDto<MenuResponse>> listMenu(){
        return  ResponseEntity.ok(dataService.findAllMenu());
    }
    @GetMapping("/payment")
    private ResponseEntity<BaseResponseDto<PaymentResponse>> listPayment(){
        return  ResponseEntity.ok(dataService.findAllPayment());
    }
    @GetMapping("/promo")
    private ResponseEntity<BaseResponseDto<PromoResponse>> listPromo(){
        return  ResponseEntity.ok(dataService.findAllPromo());
    }



}
