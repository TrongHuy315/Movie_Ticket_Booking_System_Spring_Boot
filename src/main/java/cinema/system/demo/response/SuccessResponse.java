package cinema.system.demo.response;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuccessResponse<T> {
    private final String message = "Success";
    private T data;
    private final OffsetDateTime timeStamp = OffsetDateTime.now();

    public static <T> SuccessResponse<T> of(final T data) {
        return SuccessResponse.<T>builder()
                    .data(data)
                    .build();
    }
}
