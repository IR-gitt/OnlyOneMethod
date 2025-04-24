package com.onlyOneMethod;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

import static com.onlyOneMethod.ArrayOperations.asyncQuickSort;
import static com.onlyOneMethod.ArrayOperations.selectNValueArray;
import static com.onlyOneMethod.OperationsWithExel.readNumbersFromExcel;

@RestController
@RequestMapping("/file")
@Tag(name = "File Controller", description = "Обработка Excel файлов")
public class Controller {

    @GetMapping("/process")
    @Operation(summary = "Вывод числа из файла с раширением exel", description = "выводит N-ое число из столбца exel файла")
    public Serializable returnValue(@RequestParam String filePath, @RequestParam int n) {

        return selectNValueArray(
                asyncQuickSort(
                readNumbersFromExcel(filePath)), n);
        }
    }

