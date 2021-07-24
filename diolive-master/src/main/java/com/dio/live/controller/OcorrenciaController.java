package com.dio.live.controller;

import com.dio.live.model.Ocorrencia;
import com.dio.live.service.OcorrenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    private OcorrenciaService ocorrenciaService;

    @PostMapping
    public Ocorrencia createOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.saveOcorrencia(ocorrencia);
    }

    @GetMapping
    public List<Ocorrencia> getOcorrenciaList() {
        return ocorrenciaService.findAll();
    }

    @GetMapping("/{idOcorrencia}")
    public ResponseEntity<Ocorrencia> getOcorrenciaByID(@PathVariable("idOcorrencia") Long idOcorrencia) throws Exception{
        return ResponseEntity.ok(ocorrenciaService.getById(idOcorrencia).orElseThrow(() -> new Exception("Ocorrencia não encontrada.")));
    }

    @PutMapping
    public Ocorrencia updateOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.updateOcorrencia(ocorrencia);
    }

    @DeleteMapping ("/{idOcorrencia}")
    public ResponseEntity<Ocorrencia> deleteOcorrenciaByID(@PathVariable("idOcorrencia") Long idOcorrencia) {
        try {
            ocorrenciaService.deleteOcorrencia(idOcorrencia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Ocorrencia>) ResponseEntity.ok();

    }
}
