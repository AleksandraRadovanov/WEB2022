package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Komentar;
import com.ftn.wolt2022.repository.KomentarRepository;
import org.springframework.stereotype.Service;

@Service
public class KomentarService {
    public final KomentarRepository komentarRepository;

    public KomentarService(KomentarRepository komentarRepository) {
        this.komentarRepository = komentarRepository;
    }

    public Komentar create(Komentar komentar) {
        Komentar komentar1 = new Komentar();
        komentar1.setId(komentar.getId());
        komentar1.setOcena(komentar.getOcena());
        komentar1.setRestoran(komentar.getRestoran());
        komentar1.setTekst(komentar.getTekst());

        komentarRepository.save(komentar1);
        return komentar1;
    }
}
