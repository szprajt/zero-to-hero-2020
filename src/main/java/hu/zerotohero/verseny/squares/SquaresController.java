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
        if (points.size() > 3) {
            for (int i = 0; i < points.size() - 3; i++) {
                for (int j = i + 1; j < points.size() - 2; j++) {
                    for (int k = j + 1; k < points.size() - 1; k++) {
                        for (int l = k + 1; l < points.size(); l++) {
                            Point a = points.get(i);
                            Point b = points.get(j);
                            Point c = points.get(k);
                            Point d = points.get(l);
                            if (isSquare(a, b, c, d)) {
                                result++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean isSquare(Point a, Point b, Point c, Point d) {
        int distab = squareDistance(a, b);
        int distac = squareDistance(a, b);
        int distad = squareDistance(a, b);

        if ((distab == distac) && (2 * distab == distad)) {
            int dist = squareDistance(b, d);
            return (dist == squareDistance(c, d) && dist == distab);
        }

        if ((distac == distad) && (2 * distac == distab)) {
            int dist = squareDistance(b, c);
            return (dist == squareDistance(b, d) && dist == distac);
        }

        if ((distab == distad) && (2 * distab == distac)) {
            int dist = squareDistance(b, c);
            return (dist == squareDistance(c, d) && dist == distab);
        }
        return false;
    }

    int squareDistance(Point p, Point q) {
        return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
    }
}
