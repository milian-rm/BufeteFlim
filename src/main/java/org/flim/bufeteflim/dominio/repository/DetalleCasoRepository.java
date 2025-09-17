package org.flim.bufeteflim.dominio.repository;
import org.flim.bufeteflim.dominio.dto.*;

import java.util.List;

public interface DetalleCasoRepository {
    List<DetalleCasoDto> obtenertodo();
    DetalleCasoDto buscarPorCodigo(Long id);
    DetalleCasoDto guardarDetalleCaso(DetalleCasoDto detalleCasoDto);
    DetalleCasoDto modificarDetalleCaso(Long id, ModDetalleCasoDto modDetalleCasoDto);
    void eliminarDetalleCaso(Long id);
}
