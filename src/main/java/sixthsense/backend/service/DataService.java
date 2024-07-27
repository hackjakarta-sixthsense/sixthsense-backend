package sixthsense.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sixthsense.backend.dto.BaseResponseDto;
import sixthsense.backend.dto.menuDto.DataMenu;
import sixthsense.backend.dto.menuDto.ListMenu;
import sixthsense.backend.dto.menuDto.MenuResponse;
import sixthsense.backend.dto.paymentDto.DataPayment;
import sixthsense.backend.dto.paymentDto.ListPayment;
import sixthsense.backend.dto.paymentDto.PaymentResponse;
import sixthsense.backend.dto.promo.DataPromo;
import sixthsense.backend.dto.promo.ListPromo;
import sixthsense.backend.dto.promo.PromoResponse;
import sixthsense.backend.model.Menu;
import sixthsense.backend.model.Payment;
import sixthsense.backend.model.Promo;
import sixthsense.backend.repository.MenuRepository;
import sixthsense.backend.repository.PaymentRepository;
import sixthsense.backend.repository.PromoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataService {

    private final MenuRepository menuRepository;
    private final PromoRepository promoRepository;
    private final PaymentRepository paymentRepository;


    public BaseResponseDto<MenuResponse> findAllMenu(){
        List<Menu> all = menuRepository.findAll();
        List<DataMenu> list = all.stream().map(data -> (
                DataMenu
                        .builder()
                        .icon(data.getIcon())
                        .name(data.getName())
                        .build()
        )).toList();
        ListMenu listMenu = ListMenu
                .builder()
                .listMenu(list)
                .build();
        MenuResponse menuResponse = MenuResponse
                .builder()
                .menu(listMenu)
                .build();
        BaseResponseDto<MenuResponse> baseResponseDto=new BaseResponseDto<>();
        baseResponseDto.setData(menuResponse);
        baseResponseDto.setCode(200);
        baseResponseDto.setMessage("SUCCESS");
        return baseResponseDto;
    }
    public BaseResponseDto<PaymentResponse> findAllPayment(){
        List<Payment> all = paymentRepository.findAll();
        List<DataPayment> list = all.stream().map(data -> (
                DataPayment
                        .builder()
                        .icon(data.getIcon())
                        .caption(data.getCaption())
                        .content(data.getContent())
                        .build()
        )).toList();
        ListPayment listPayment = ListPayment
                .builder()
                .listPayment(list)
                .build();
        PaymentResponse paymentResponse = PaymentResponse
                .builder()
                .payment(listPayment)
                .build();
        BaseResponseDto<PaymentResponse> baseResponseDto=new BaseResponseDto<>();
        baseResponseDto.setData(paymentResponse);
        baseResponseDto.setCode(200);
        baseResponseDto.setMessage("SUCCESS");
        return baseResponseDto;
    }
    public BaseResponseDto<PromoResponse> findAllPromo(){

        List<Promo> all = promoRepository.findAll();
        List<DataPromo> list = all.stream().map(data -> (
                DataPromo
                        .builder()
                        .image(data.getImage())
                        .title(data.getTitle())
                        .validUntil(data.getValidationUtil())
                        .build()
        )).toList();
        ListPromo listPromo = ListPromo
                .builder()
                .listPromo(list)
                .title("Celebrate Mid-Autumn Festival")
                .build();
        PromoResponse promoResponse = PromoResponse
                .builder()
                .promo(listPromo)
                .build();
        BaseResponseDto<PromoResponse> baseResponseDto=new BaseResponseDto<>();
        baseResponseDto.setData(promoResponse);
        baseResponseDto.setCode(200);
        baseResponseDto.setMessage("SUCCESS");
        return baseResponseDto;
    }
}
