package com.grammatico.negozio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.outputDTO.TransazioneDetailOutputDTO;
import com.grammatico.negozio.DTO.outputDTO.TransazioneSummaryOutputDTO;
import com.grammatico.negozio.DTO.outputDTO.VenditaProdottoOutputDTO;
import com.grammatico.negozio.DTO.outputDTO.mapper.ClienteSimpleOutputDTOMapper;
import com.grammatico.negozio.DTO.outputDTO.mapper.TransazioneSummaryOutputDTOMapper;
import com.grammatico.negozio.model.entity.Cliente;
import com.grammatico.negozio.model.entity.Transazione;
import com.grammatico.negozio.repository.ClienteRepository;
import com.grammatico.negozio.repository.ProdottoRepository;
import com.grammatico.negozio.repository.TransazioneRepository;
import com.grammatico.negozio.service.interfaces.ITransazioneService;

@Service
public class TransazioneService implements ITransazioneService {

    TransazioneRepository transazioneRepository;
    ProdottoRepository prodottoRepository;
    ClienteRepository clienteRepository;
    TransazioneSummaryOutputDTOMapper transazioneSummaryOutputDTOMapper;
    ClienteSimpleOutputDTOMapper clienteSimpleOutputDTOMapper;

    public TransazioneService(
        TransazioneRepository transazioneRepository,
        ProdottoRepository prodottoRepository,
        ClienteRepository clienteRepository,
        TransazioneSummaryOutputDTOMapper transazioneSummaryOutputDTOMapper,
        ClienteSimpleOutputDTOMapper clienteSimpleOutputDTOMapper
    ) {
        this.transazioneRepository = transazioneRepository;
        this.prodottoRepository = prodottoRepository;
        this.clienteRepository = clienteRepository;
        this.transazioneSummaryOutputDTOMapper = transazioneSummaryOutputDTOMapper;
        this.clienteSimpleOutputDTOMapper = clienteSimpleOutputDTOMapper;
    }

    @Override
    public List<TransazioneSummaryOutputDTO> getSummary() {
        return this.transazioneRepository.findAllByOrderByData().stream().map(this.transazioneSummaryOutputDTOMapper).collect(Collectors.toList());
    }

    @Override
    public TransazioneDetailOutputDTO getDetailFromId(Long id) {
        Transazione transazione = null;
        Optional<Transazione> optTransazione;
        List<VenditaProdottoOutputDTO> venditeProdotto = new ArrayList<>();
        Optional<Cliente> optCliente;
        Cliente cliente = null;

        System.out.println("Sono all'inizio del servizio");
        // prendo la transazione con l'id dato
        try {
            optTransazione = transazioneRepository.findById(id);

            if (!optTransazione.isPresent()) {
                System.out.println("Transazione non trovata");
                return null;
            } else {
                transazione = optTransazione.get();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Ho preso la transazione");
        // prendo tutte le vendite (anche con il relativo nome e prezzo del prodotto) della transazione con id dato
        try {
            venditeProdotto = prodottoRepository.getAllVenditeProdottoFromIdTransazione(id);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Ho preso le vendite prodotto");
        // se la transazione è stata generata dall'acquisto di un prodotto prendo il cliente interessato
        try {
            if (transazione != null && transazione.getIdCliente() != null) {
                optCliente = clienteRepository.findById(transazione.getIdCliente());
                if (!optCliente.isPresent()) {
                    System.out.println("Cliente non trovato");
                    return null;
                } else {
                    cliente = optCliente.get();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Ho preso il cliente");
        if (transazione != null) {
            // costruisco TransazioneDetailOutputDTO
            TransazioneDetailOutputDTO transazioneDetail = new TransazioneDetailOutputDTO(
                transazione.getId(),
                transazione.getData(),
                transazione.getTipo(),
                transazione.getPrezzoTotale(),
                transazione.getInfo(),
                venditeProdotto,
                cliente != null ? this.clienteSimpleOutputDTOMapper.apply(cliente) : null
            );
            return transazioneDetail;
        } else {
            return null;
        }

    }
    
}
