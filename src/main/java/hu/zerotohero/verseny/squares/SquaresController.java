package hu.zerotohero.verseny.squares;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/squares")
public class SquaresController {

    @GetMapping("/getNumberOfSquares")
    public Integer getNumberOfSquares(@RequestBody List<Point> points) {
        int result = 0;
        if (points.size() > 1) {
            for (int i = 0; i < points.size() - 1; i++) {
                for (int j = i + 1; j < points.size(); j++) {
                    Point first = points.get(i);
                    Point second = points.get(j);
                    if (first.x != second.x && (first.x - second.x == second.y - second.x)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
