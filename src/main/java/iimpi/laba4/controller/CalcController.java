package iimpi.laba4.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/calc")
public class CalcController {

    @GetMapping("/add")
    public int add(@RequestParam int x, @RequestParam int y) {
        return x + y;
    }

    @GetMapping("/sub")
    public int sub(@RequestParam int x, @RequestParam int y) {
        return x - y;
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam int x, @RequestParam int y) {
        return x * y;
    }

    @GetMapping("/divide")
    public ResponseEntity<Integer> divide(@RequestParam int x, @RequestParam int y) {
        if (y == 0) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok(x / y);
    }

}
