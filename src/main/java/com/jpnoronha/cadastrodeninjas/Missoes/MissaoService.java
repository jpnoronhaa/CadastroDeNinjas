package com.jpnoronha.cadastrodeninjas.Missoes;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {

    private final MissaoRepository repository;
    private final MissaoMapper mapper;

    public MissaoService(MissaoRepository repository, MissaoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<MissaoDTO> getAll() {
        List<MissaoDTO> missoes = repository.findAll()
                .stream()
                .map(mapper::map)
                .toList();
        return missoes;
    }

    public MissaoDTO getById(Long id) {
        MissaoDTO missao = repository.findById(id).map(mapper::map).orElse(null);
        return missao;
    }

    public MissaoDTO save(MissaoDTO missao) {
        MissaoModel missaoModel = mapper.map(missao);
        MissaoModel saved = repository.save(missaoModel);
        return mapper.map(saved);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public MissaoDTO update(Long id, MissaoDTO missaoDTO) {
        MissaoDTO missaoOld = this.getById(id);
        if (missaoOld != null) {
            MissaoModel missaoModel = mapper.map(missaoDTO);
            missaoModel.setId(id);
            repository.save(missaoModel);
            return mapper.map(missaoModel);
        }
        return null;
    }
}
