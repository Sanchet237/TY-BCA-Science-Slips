package sub

import "testing"

func TestSub(t *testing.T) {
	tests := []struct {
		a, b int
		want int
	}{
		{10, 5, 5},
		{20, 8, 12},
	}

	for _, tt := range tests {
		if Sub(tt.a, tt.b) != tt.want {
			t.Fail()
		}
	}
}
