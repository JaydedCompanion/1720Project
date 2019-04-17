package Game;

enum ShapeTypes {
    circle,
    square,
    triangle
}

public class Shape extends GridTileBase {

    private ShapeTypes shape;
    
    public Shape(ShapeTypes shape) {
        
        this.shape = shape;
    
        switch (shape) {
        
            case circle: {
            
                switch ((int)(Math.random()*3)+1) {
                    case 1:{ setAnimPath("../Res/Payload.Circle_8Ball.png");break;}
                    case 2:{ setAnimPath("../Res/Payload.Circle_ChocoDonut.png");break;}
                    case 3:{ setAnimPath("../Res/Payload.Circle_Donut.png");break;}
                }
            
                break;
            }
            
            case square: {
            
                switch ((int)(Math.random()*3)+1) {
                    case 1:{ setAnimPath("../Res/Payload.Square_Crate.png");break;}
                    case 2:{ setAnimPath("../Res/Payload.Square_Parcel.png");break;}
                    case 3:{ setAnimPath("../Res/Payload.Square_ParcelTilted.png");break;}
                }
            
                break;
            }
            
            case triangle: {
            
                switch ((int)(Math.random()*2)+1) {
                    case 1:{ setAnimPath("../Res/Payload.Triangle_Cheese.png");break;}
                    case 2:{ setAnimPath("../Res/Payload.Triangle_Watermelon.png");break;}
                }
            
                break;
            }
            
        }
    
    }
    
}
